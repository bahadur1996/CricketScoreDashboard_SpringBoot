package com.backendcode.assignment.scheduler;

import com.backendcode.assignment.model.Channel;
import com.backendcode.assignment.model.Item;
import com.backendcode.assignment.service.ChannelService;
import com.backendcode.assignment.service.ItemService;
import com.backendcode.assignment.util.ApiCallerUtil;
import com.backendcode.assignment.util.JSONUtils;
import com.backendcode.assignment.util.XmlUtil;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class LiveScoreUpdatingScheduler {

    private final Environment environment;
    private final ChannelService channelService;
    private final ItemService itemService;
    private final Logger logger = Logger.getLogger(LiveScoreUpdatingScheduler.class);

    @Scheduled(cron = "0 */5 * * * *", zone = "UTC")
    public void updateLiveScore() {
        logger.info("***** Live score updating task started...." + new Date());

        String xmlResponse = ApiCallerUtil.executeGetMethod(environment.getProperty("updated.score.url"), null);
        if (!XmlUtil.isXML(xmlResponse)) {
            return;
        }
        JSONObject jsonResponse = XML.toJSONObject(xmlResponse);

        Channel channel = JSONUtils.INTANCE.fromJson(jsonResponse.getJSONObject("rss").getJSONObject("channel").toString(), Channel.class);
        channel.setPubTimestamp(getTimeStamp(channel.getPubDate()));
        List<Item> items = channel.getItems();

        if (channelService.getByPubTimestamp(channel.getPubTimestamp()) != null) {
            return;
        }
        channel = channelService.saveChannel(channel);

        final long channelId = channel.getId();

        items = items.stream().map(item -> item.setChannelId(channelId)).collect(Collectors.toList());
        itemService.saveItems(items);

        logger.info("***** Live score updating task completed...." + new Date());
    }

    private Long getTimeStamp(String pubDate) {
        DateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        try {
            Date date = formatter.parse(pubDate);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0l;
        }
    }
}

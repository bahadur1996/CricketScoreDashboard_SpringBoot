package com.backendcode.assignment.serviceimpl;

import com.backendcode.assignment.entity.ChannelEntity;
import com.backendcode.assignment.mapper.ChannelMapper;
import com.backendcode.assignment.model.Channel;
import com.backendcode.assignment.repository.ChannelRepository;
import com.backendcode.assignment.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelMapper channelMapper;
    private final ChannelRepository channelRepository;
    @Override
    public Channel saveChannel(Channel channel) {
        ChannelEntity channelEntity = channelRepository.save(channelMapper.modelToEntity().map(channel));
        channel = channelMapper.entityToModel().map(channelEntity);
        return channel;
    }

    @Override
    public Channel getByPubTimestamp(Long pubTimestamp) {
        ChannelEntity channel = channelRepository.findByPubTimestamp(pubTimestamp);
        return channel == null? null : channelMapper.entityToModel().map(channel);
    }
}

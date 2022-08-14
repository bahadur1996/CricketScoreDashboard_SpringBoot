package com.backendcode.assignment.service;

import com.backendcode.assignment.model.Channel;

public interface ChannelService {
    Channel saveChannel(Channel channel);
    Channel getByPubTimestamp(Long pubTimestamp);
}

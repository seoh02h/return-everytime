package com.seohyuni.returneverytimeserver.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SocketChatController {

  private final ChatService chatService;

  @MessageMapping("/lounge/{loungeId}/chat/receive")
  @SendTo("/lounge/{loungeId}/chat/send")
  public ChatOut chatHandler(@DestinationVariable Long loungeId, LoungeSocketDto.ChatIn in) {
    return chatService.sendChat(loungeId, in);
  }
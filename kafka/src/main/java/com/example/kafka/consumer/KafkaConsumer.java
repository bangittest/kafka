package com.example.kafka.consumer;

import static java.lang.String.format;

import com.example.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//  @KafkaListener(topics = "alibout",groupId = "myGroup")
  public void consumeMsg(String msg){
    log.info(format("Consuming the message from alibout Topic :: %s" ,msg));
  }

  @KafkaListener(topics = "alibout",groupId = "myGroup")
  public void consumeJsonMsg(Student student){
    log.info(format("Consuming the message from alibout Topic :: %s" ,student.toString()));
  }


}

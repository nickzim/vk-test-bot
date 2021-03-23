package com.nickzim.controllers;

import com.nickzim.Configuration;
import com.nickzim.domain.events.Event;
import com.nickzim.vkapi.ServerApiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ServerApiImpl serverApi;

    @RequestMapping(value = "/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getMessage(@RequestBody Event event){

        switch (event.getType()){

            case "confirmation": {
                return Configuration.getConfirmMessage();
            }

            case "message_new": {
                serverApi.sendMessage(event.getObject().getMessage());
                return "ok";
            }

            default: {
                return null;
            }
        }

    }



}

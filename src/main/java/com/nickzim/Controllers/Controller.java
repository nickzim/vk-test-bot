package com.nickzim.controllers;

import com.nickzim.Configuration;
import com.nickzim.domain.events.Event;
import com.nickzim.vkapi.ServerApiImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class Controller {

    private final ServerApiImpl serverApi;

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

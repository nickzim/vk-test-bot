package com.nickzim.Controllers;

import com.nickzim.DTOs.EventPackage.Event;
import com.nickzim.VkApi.ServerApiImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private ServerApiImpl serverApi = new ServerApiImpl();

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(){
        return "success";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getMessage(@RequestBody Event event){

        switch (event.getType()){

            case "confirmation": {
                return "864eb6e5";
            }

            case "message_new": {

                System.out.println("Запрос: " + event.getObject().getMessage().toString());

                serverApi.sendMessage(event.getObject().getMessage());
                return "ok";
            }

            default: {
                return null;
            }
        }

    }



}

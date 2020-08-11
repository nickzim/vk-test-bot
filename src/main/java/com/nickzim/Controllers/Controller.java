package com.nickzim.Controllers;

import com.nickzim.DTOs.Event;
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

        System.out.println(event.getObject().getBody());

        serverApi.sendMessage(event.getObject());

        return "ok";
    }


}

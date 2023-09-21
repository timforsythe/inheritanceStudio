package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello")
public class HelloController {

    /*
    //Handles request at path /hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // Lives at /hello/goodbye


    // Lives at /hello/hello
    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }


    // Lives at /hello/form
    @RequestMapping(value="hello", method = RequestMethod.GET)
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me' />" +
                "</form>";
                    //"<body>" +
                        //"<form action='hello' method='post'>" + //submit a request to /hello
                            //"<input type='text' name='name'>" +
                   // "</body>" +
               // "</html>";
        return html;
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        } else if (l.equals("spanish")) {
            greeting = "Hola";
        } else if (l.equals("german")) {
            greeting = "Hallo";
        } else if (l.equals("french")) {
            greeting = "Bonjour";
        } else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }

        return greeting + " " + n;
    }

    // Handles requests of the form /hello/{name}
    @RequestMapping(value="hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    @RequestMapping(value="goodbye")
    public String goodbye() {
        return "Goodbye!";
    }

}

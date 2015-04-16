package com.nexse.websample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: pasquale
 * Date: 14/04/15
 * Time: 19.27
 */
@Controller
public class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    private static int counter = 0;
    private static long sleep = 0;

    private static final String VIEW_INDEX = "index";
    private static final String VIEW_SLEEP = "sleep";

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service(ModelMap model) {
        model.addAttribute("counter", ++counter);
        model.addAttribute("sleep", sleep);
        logger.debug("[service] counter: {}", counter, sleep);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        model.addAttribute("counter", counter);
        model.addAttribute("sleep", sleep);
        logger.debug("[all] counter: {}", counter, sleep);
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/all/**", method = RequestMethod.GET)
    public String allSubDir(ModelMap model) {
        model.addAttribute("counter", counter);
        model.addAttribute("sleep", sleep);
        logger.debug("[allSubDir] counter: {}", counter, sleep);
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/setSleep/{sleep}", method = RequestMethod.PUT)
    public String setSleep(@PathVariable long sleep, ModelMap model) {
        BaseController.sleep = sleep;
        model.addAttribute("sleep", sleep);
        logger.debug("[setSleep] sleep: {}", sleep);
        return VIEW_SLEEP;
    }

}

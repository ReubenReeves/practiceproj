package com.practice.controllers;

import com.practice.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    private static final String ACCOUNT_VIEW = "account";
    private static final String MATCHES_VIEW = "matches";
    private static final String ACCOUNT_MAV_KEY = "account";
    private static final String MATCHLIST_MAV_KEY = "matchList";

    @Autowired
    public BaseService baseService;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHome(){
        return "home";
    }

    @RequestMapping(value = "/addMatches/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public boolean addMatches(@PathVariable int accountId) {
        return baseService.addMatchesForAccount(accountId);
    }

    @RequestMapping(value = "/getMatches", method = RequestMethod.GET)
    public ModelAndView getMatches(@RequestParam("accountId") int accountId) {
        ModelAndView mav = new ModelAndView(MATCHES_VIEW);
        mav.addObject(MATCHLIST_MAV_KEY, baseService.getMatchesById(accountId));
        return mav;
    }

    @RequestMapping(value = "/addAccount/{accountName}", method = RequestMethod.GET)
    @ResponseBody
    public boolean addAccount(@PathVariable String accountName) {
        return baseService.addAccount(accountName);
    }

    @RequestMapping(value = "getAccountByName/{accountName}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAccountByName(@PathVariable String accountName) {
        ModelAndView mav = new ModelAndView(ACCOUNT_VIEW);
        mav.addObject(ACCOUNT_MAV_KEY, baseService.getAccountByName(accountName));
        return mav;
    }


    @RequestMapping(value = "getAccountById/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public String getAccountBId(@PathVariable int accountId) {
        return baseService.getAccountJsonById(accountId);
    }

    @RequestMapping(value = "getAccountById", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchAccountById(@RequestParam("accountId") int accountId) {
        ModelAndView mav = new ModelAndView(ACCOUNT_VIEW);
        mav.addObject(ACCOUNT_MAV_KEY,baseService.getAccountById(accountId));
        return mav;
    }

    @RequestMapping(value = "getAccountByName", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchAccountByName(@RequestParam("accountName") String accountName) {
        ModelAndView mav = new ModelAndView(ACCOUNT_VIEW);
        mav.addObject(ACCOUNT_MAV_KEY, baseService.getAccountByName(accountName));
        return mav;
    }
}
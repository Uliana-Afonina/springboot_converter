package com.afonina.converter.springboot_converter.service;

import com.afonina.converter.springboot_converter.entity.ValutesCurses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarshallerServiceTest {
    MarshallerService marshallerService = new MarshallerService();
    @Test
    void getValutesCursesTest() {
        ValutesCurses valutesCurses = marshallerService.getValutesCurses();
        System.out.println(valutesCurses);
    }

    @Test
    void getValutesTest() {
        ValutesCurses valutesCurses = marshallerService.getValutesCurses();
        System.out.println(valutesCurses.getValutes());
    }
}
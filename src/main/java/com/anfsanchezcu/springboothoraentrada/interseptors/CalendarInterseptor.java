package com.anfsanchezcu.springboothoraentrada.interseptors;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component("calendarInterseptor")
public class CalendarInterseptor implements HandlerInterceptor {

  @Value("${config.calendar.open}")
  private int openHour;
  @Value("${config.calendar.close}")
  private int closeHour;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    Map<String, Object> res = new HashMap<>();

    if (openHour <= hour && hour < closeHour) {

      request.setAttribute("message", "Gracias por visitarnos, estamos abiertos");
      return true;
    }

    ObjectMapper mapper = new ObjectMapper();
    res.put("message", "Gracias por visitarnos, estamos cerrados");
    response.setContentType("application/json");
    response.setStatus(401);
    response.getWriter().write(mapper.writeValueAsString(res));
    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {

    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

}

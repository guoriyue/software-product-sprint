// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns a random quote. */
@WebServlet("/random-quote")
public final class RandomQuoteServlet extends HttpServlet {

  private List<String> quotes;

  @Override
  public void init() {
    quotes = new ArrayList<>();
    quotes.add(
        "Hello! I am Mingfei Guo!");
    quotes.add("My name is Riyue Guo!");
    quotes.add("您好！我是郭明非！");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //String quote = quotes.get((int) (Math.random() * quotes.size()));
    String name = request.getParameter("name-input");
    String color = request.getParameter("color-input");
    String description = request.getParameter("description-input");

    //response.setContentType("text/html;");
    response.setContentType("text/html;");
    response.getWriter().println(name);
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String name = request.getParameter("name-input");
    String color = request.getParameter("color-input");
    String description = request.getParameter("description-input");

    response.setContentType("text/html;");
    
    /*response.getWriter().println("<p>Name: " + name + "</p>");
    response.getWriter().println("<p>Color: " + color + "</p>");
    response.getWriter().println("<p>Description: " + description + "</p>");*/
  }
}

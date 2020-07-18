package com.google.sps.servlets;

public final class Comment {
  private final long id;
  private final String text;
  private final String userEmail;
  private final double score;
  private final double time;
  public Comment(long id, String text, String userEmail,double score,long time) {
    this.id = id;
    this.text = text;
    this.userEmail=userEmail;
    this.score=score;
    this.time=time;
  }
}

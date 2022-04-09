package net.jungly.coins.mongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Model {

  @JsonProperty("_id")
  String getId();
}

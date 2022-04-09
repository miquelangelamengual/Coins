package net.jungly.coins.mongo.repository;

import net.jungly.coins.mongo.model.Model;

/**
 * Created by HarpyLMAO
 * at 19/09/2021 15:46
 * all credits reserved
 */

public interface ObjectRepository<O extends Model> {

  O find(String id);
  void remove(String id);
  void save(O model);
}

package net.jungly.coins.mongo.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import net.jungly.coins.mongo.model.Model;

/**
 * Created by HarpyLMAO
 * at 19/09/2021 15:48
 * all credits reserved
 */

public class MongoObjectRepository<O extends Model> implements ObjectRepository<O> {

  private MongoCollection<O> collection;

  public MongoObjectRepository(
          MongoCollection<O> collection
  ) {
    this.collection = collection;
  }

  @Override
  public O find(String id) {
    return collection.find(Filters.eq("_id", id)).first();
  }

  @Override
  public void remove(String id) {
    this.collection.deleteOne(Filters.eq("_id", id));
  }

  @Override
  public void save(O model) {
    this.collection.replaceOne(
            Filters.eq("_id", model.getId()),
            model,
            new ReplaceOptions().upsert(true)
    );
  }
}

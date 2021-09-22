package org.launchcode.demo.models.data;

import org.launchcode.demo.controllers.PostMessageController;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.launchcode.demo.models.PostMessage;

@Repository
public interface PostMessageRepository extends CrudRepository<PostMessage,Integer> {
}

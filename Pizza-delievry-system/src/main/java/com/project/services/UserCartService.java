package com.project.services;

import com.project.entity.CartEntity;
import com.project.json.CartJson;

public interface UserCartService {

	CartJson additems(CartJson cart, String cartid, String cartid2);

	CartJson delete(String id, long cartid, String foodid);


}

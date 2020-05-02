package com.project.services;

import com.project.json.CartJson;

public interface UserCartService {

	CartJson additems(CartJson cart, String cartid);

}

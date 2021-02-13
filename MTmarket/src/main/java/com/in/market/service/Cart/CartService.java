package com.in.market.service.cart;




import com.in.market.pojo.cart.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> queryByUserId(Integer cartUser);

    public void saveGoodsToCart(String jsonData) throws Exception;

    void updateGoodsNumForCart(Integer cartId, Integer cartNum);

    void deleteGoodsFromCart(Integer cartId);
}

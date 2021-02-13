package com.in.market.controller.cart;




import com.in.market.pojo.cart.Cart;
import com.in.market.service.cart.CartService;
import com.in.market.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cart")
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 将商品加入到购物车
     * */
    @RequestMapping(value = "/add",method =RequestMethod.POST)
    public ResponseEntity<Void> addGoodsToCart(@RequestBody String jsonData){
        try{
            System.out.println(jsonData);
            this.cartService.saveGoodsToCart(jsonData);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
     //  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 修改商品购买个数
     * */
    @RequestMapping(value = "/update/{cartId}/{cartNum}",method = RequestMethod.GET)
    public ResponseEntity<Void> updateGoodsNumForCart(@PathVariable(value = "cartId")Integer cartId,
                                                      @PathVariable(value = "cartNum")Integer cartNum){
        try{
            this.cartService.updateGoodsNumForCart(cartId,cartNum);
        //204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 从购物车删除商品
     * */

    @RequestMapping(value = "/delete/{cartId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGoodsFromCart(@PathVariable(value = "cartId")Integer cartId){
        try{
            this.cartService.deleteGoodsFromCart(cartId);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 通过userId查询购物车
     * */
    @RequestMapping(value = "/{cartUser}/query",method = RequestMethod.GET)
    public ResponseEntity<ResultList> queryCarts(@PathVariable(value = "cartUser") Integer cartUser){
        try{
            List<Cart> carts = this.cartService.queryByUserId(cartUser);
            ResultList resultList = new ResultList(carts.size(),carts);

            return ResponseEntity.ok(resultList);
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



}

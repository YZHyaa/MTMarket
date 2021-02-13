package com.in.market.service.order;


import com.in.market.pojo.order.Order;
import com.in.market.util.ResultList;

import java.util.Map;

public interface OrderService {
    String createOrder(String jsonOrder);

    Order queryByOrderId(String orderId);

//    ResultList queryListByNickName(String nickName, Integer page, Integer count);

    void changeOrderStatus(String jsonData) throws Exception;

    void changeOrderStatus2(String orderId) throws Exception;

    ResultList queryByUserId(Integer orderUser) throws Exception;

    ResultList queryOrderByUserIdAndState(Map<String, Object> map);

    void deleteOrderByOrderId(String orderId);
}

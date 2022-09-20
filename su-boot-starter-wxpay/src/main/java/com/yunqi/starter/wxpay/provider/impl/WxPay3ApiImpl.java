package com.yunqi.starter.wxpay.provider.impl;

import com.yunqi.starter.common.json.Json;
import com.yunqi.starter.wxpay.model.WxPayResponse;
import com.yunqi.starter.wxpay.provider.WxPay3Api;
import com.yunqi.starter.wxpay.spi.WxPays;
import com.yunqi.starter.wxpay.util.WxPayUtil;
import org.nutz.lang.util.NutMap;

/**
 * Created by @author CHQ on 2022/9/20
 */
public class WxPay3ApiImpl implements WxPay3Api {

    @Override
    public WxPayResponse certificates() throws Exception {
        String url = "/v3/certificates";
        return WxPayUtil.call("GET", url, null, "");
    }

    @Override
    public WxPayResponse order_jsapi(String body) throws Exception {
        String url = "/v3/pay/transactions/jsapi";
        return WxPayUtil.call("POST", url, null, body);
    }

    @Override
    public WxPayResponse order_app(String body) throws Exception {
        String url = "/v3/pay/transactions/app";
        return WxPayUtil.call("POST", url,null, body);
    }

    @Override
    public WxPayResponse order_native(String body) throws Exception {
        String url = "/v3/pay/transactions/native";
        return WxPayUtil.call("POST", url, null, body);
    }

    @Override
    public WxPayResponse order_h5(String body) throws Exception {
        String url = "/v3/pay/transactions/h5";
        return WxPayUtil.call("POST", url,null, body);
    }

    @Override
    public WxPayResponse order_close(String out_trade_no) throws Exception {
        String url = "/v3/pay/transactions/out-trade-no/" + out_trade_no + "/close";
        String body = Json.toJson(NutMap.NEW().addv("mchid", WxPays.config.getMchId()));
        return WxPayUtil.call("POST", url, null, body);
    }

    @Override
    public WxPayResponse order_query_transaction_id(String transaction_id) throws Exception {
        String url = "/v3/pay/transactions/id/" + transaction_id;
        return WxPayUtil.call("GET", url,null, "");
    }

    @Override
    public WxPayResponse order_query_out_trade_no(String out_trade_no) throws Exception {
        String url = "/v3/pay/transactions/out_trade_no/" + out_trade_no + "?mchid=" + WxPays.config.getMchId();
        return WxPayUtil.call("GET", url,null, "");
    }

    @Override
    public WxPayResponse ecommerce_refunds_apply(String body) throws Exception {
        String url = "/v3/ecommerce/refunds/apply";
        return WxPayUtil.call("POST", url, null, body);
    }

    @Override
    public WxPayResponse ecommerce_refunds_query_refund_id(String refund_id) throws Exception {
        String url = "/v3/ecommerce/refunds/id/" + refund_id + "?sub_mchid=" + WxPays.config.getMchId();
        return WxPayUtil.call("GET", url,null, "");
    }

    @Override
    public WxPayResponse ecommerce_refunds_query_out_refund_no(String out_refund_no) throws Exception {
        String url = "/v3/ecommerce/refunds/out-refund-no/" + out_refund_no + "?sub_mchid=" + WxPays.config.getMchId();
        return WxPayUtil.call("GET", url, null, "");
    }
}

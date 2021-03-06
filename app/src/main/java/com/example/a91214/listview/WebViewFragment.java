package com.example.a91214.listview;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Base64;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import  com.example.a91214.listview.R;

/**
 * Created by 91214 on 2018/10/31.
 */

public class WebViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //String name = this.getArguments().getString("title");
        View contentView = inflater.inflate(R.layout.fragment_web_view, container, false);
        WebView webView = (WebView)contentView.findViewById(R.id.webview);
        //用于在本地显示而不是弹出一个新窗口
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.baidu.com/");
        return contentView;
        //return webView;
    }
}

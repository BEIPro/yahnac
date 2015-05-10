package com.malmstein.yahnac.drawer.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.malmstein.yahnac.R;
import com.malmstein.yahnac.drawer.NavDrawerListener;
import com.malmstein.yahnac.drawer.items.NavDrawerItem;
import com.malmstein.yahnac.drawer.items.NavDrawerItemViewHolder;
import com.malmstein.yahnac.drawer.items.NewsItem;
import com.malmstein.yahnac.drawer.items.SettingsFooterItem;
import com.malmstein.yahnac.views.fonts.YahnacTextView;

public class NavDrawerItemView extends YahnacTextView implements NavDrawerItemViewHolder {

    public NavDrawerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavDrawerItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public View asView() {
        return this;
    }

    @Override
    public void bind(NavDrawerItem item, NavDrawerListener listener) {
        if (item instanceof SettingsFooterItem) {
            bindAsSettings(listener);
        } else if (item instanceof NewsItem) {
            bindAsNews(listener);
        } else {
            throw new IllegalArgumentException(String.format("SettingsFooterItem or FaqFooterItem expected - got '%s' instead.", item.getClass().getName()));
        }
    }

    private void bindAsSettings(NavDrawerListener listener) {
        setText(R.string.navigation_drawer_settings);
        setCompoundDrawable(R.drawable.ic_app_settings);
        bindClickToSettings(listener);
    }

    private void setCompoundDrawable(int drawableResourceId) {
        Drawable drawable = getResources().getDrawable(drawableResourceId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        setCompoundDrawables(drawable, null, null, null);
    }

    private void bindClickToSettings(final NavDrawerListener listener) {
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onSettingsClicked();
                }
            }
        });
    }

    private void bindAsNews(NavDrawerListener listener) {
        setText(R.string.navigation_drawer_news);
        setCompoundDrawable(R.drawable.ic_app_settings);
        bindClickToFaq(listener);
    }

    private void bindClickToFaq(final NavDrawerListener listener) {
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onNewsClicked();
                }
            }
        });
    }

}

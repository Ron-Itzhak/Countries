package com.example.countries;

import com.bumptech.glide.module.AppGlideModule;


@com.bumptech.glide.annotation.GlideModule
public class MyGlideModule extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}



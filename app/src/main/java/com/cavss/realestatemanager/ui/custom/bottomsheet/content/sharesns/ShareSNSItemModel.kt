package com.cavss.realestatemanager.ui.custom.bottomsheet.content.sharesns

import com.cavss.realestatemanager.R


sealed class ShareSNSItemModel(
    val appType : ShareSNSType,
    val appImage : Int
){
    object KAKAOTALK : ShareSNSItemModel(ShareSNSType.KAKAOTALK, R.drawable.image_kt)
    object WHATSAPP : ShareSNSItemModel(ShareSNSType.WHATSAPP, R.drawable.image_whatsapp)
    object LINE : ShareSNSItemModel(ShareSNSType.LINE, R.drawable.image_line_message)
    object TELEGRAM : ShareSNSItemModel(ShareSNSType.TELEGRAM, R.drawable.image_telegram)
    object FACEBOOK : ShareSNSItemModel(ShareSNSType.FACEBOOK, R.drawable.image_facebook_message)
    object INSTA : ShareSNSItemModel(ShareSNSType.INSTAGRAM, R.drawable.image_instagram_message)

    object LIST {
        val list = listOf(
            KAKAOTALK, WHATSAPP, LINE, TELEGRAM, FACEBOOK, INSTA
        )
    }
}
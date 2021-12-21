package com.cavss.realestatemanager.model

import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.type.TopBarType

sealed class TopBarModel(
    val itemType : TopBarType,
    val itemTitle : Int
) {
    object NOTIFY : TopBarModel(itemType = TopBarType.NOTIFY, itemTitle = R.string.topbar_notify )
    object CONTACT : TopBarModel(itemType = TopBarType.CONTACTUS, itemTitle = R.string.topbar_contact)

    object TOPBAR_LIST {
        val mainList = listOf(
            NOTIFY, CONTACT
        )
    }

}
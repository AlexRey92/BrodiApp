package com.e.brodiapp.Welcome

import android.view.View
import com.e.brodiapp.LOGIN.ProfilePicture

interface OnAvatarListener {
        fun onAvatarSelected(avatar: () -> ProfilePicture)
}
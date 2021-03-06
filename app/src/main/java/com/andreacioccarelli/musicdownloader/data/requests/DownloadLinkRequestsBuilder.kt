package com.andreacioccarelli.musicdownloader.data.requests

import android.util.Base64
import com.andreacioccarelli.musicdownloader.constants.*
import com.andreacioccarelli.musicdownloader.data.formats.Format
import com.andreacioccarelli.musicdownloader.data.parsers.ConverterUrlParser
import okhttp3.Request

/**
 * Created by andrea on 2018/Aug.
 * Part of the package andreacioccarelli.musicdownloader.data.generator
 */

object DownloadLinkRequestsBuilder {
    fun get(id: String, format: Format): Request = Request.Builder()
            .url(ConverterUrlParser.parse(id, format))
            .header(HEADER_ACCEPT, "*/*")
            .header(HEADER_DNT, "1")
            .header(HEADER_ORIGIN, Base64.decode(FROM_AUTH_URL, Base64.DEFAULT).toString(Charsets.UTF_8))
            .header(HEADER_REFERER, Base64.decode(FROM_AUTH_URL, Base64.DEFAULT).toString(Charsets.UTF_8))
            .header(HEADER_USER, USER_AGENT)
            .build()
}
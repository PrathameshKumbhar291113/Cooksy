package com.prathameshkumbhar.cooksy.common

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class OtpViewEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {

    var onPasteListener: ((String) -> Unit)? = null

    override fun onTextContextMenuItem(id: Int): Boolean {
        if (id == android.R.id.paste) {
            // Get the clipboard data (pasted text)
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
            clipboard.primaryClip?.getItemAt(0)?.text?.let { pastedText ->
                onPasteListener?.invoke(pastedText.toString())
            }
        }
        return super.onTextContextMenuItem(id)
    }
}

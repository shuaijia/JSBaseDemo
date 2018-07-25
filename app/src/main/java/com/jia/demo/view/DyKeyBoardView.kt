package com.jia.demo.view

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.os.Build
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.jia.demo.R


/**
 * Description: 斗鱼Tv自定义键盘
 * Created by jia on 2018/7/24.
 * 人之所以能，是相信能。
 */
class DyKeyBoardView : RelativeLayout, View.OnClickListener, View.OnFocusChangeListener {

    private val chars = arrayOf("A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X",
            "Y", "Z", "0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9")

    private var mCharRv: RecyclerView? = null
    private var mClearTv: TextView? = null
    private var mBackSpaceTv: TextView? = null
    private var mChangeTv: TextView? = null

    var listener: OnTextChangedListener? = null

    private val content = StringBuilder()

    constructor(context: Context) : super(context, null) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        val v = LayoutInflater.from(context).inflate(R.layout.view_keyboard, this, true)
        mCharRv = v.findViewById(R.id.rv_char) as RecyclerView?
        mClearTv = v.findViewById(R.id.tv_clear) as TextView?
        mBackSpaceTv = v.findViewById(R.id.tv_backspace) as TextView?
        mChangeTv = v.findViewById(R.id.tv_change) as TextView?

        initRv()

        initListener()
    }

    private fun initListener() {
        mClearTv!!.setOnClickListener(this)
        mBackSpaceTv!!.setOnClickListener(this)
        mChangeTv!!.setOnClickListener(this)

        mClearTv!!.onFocusChangeListener = this
        mBackSpaceTv!!.onFocusChangeListener = this
        mChangeTv!!.onFocusChangeListener = this
    }

    private fun initRv() {

        val glm = GridLayoutManager(context, 6)
        glm.orientation = LinearLayoutManager.VERTICAL
        mCharRv!!.layoutManager = glm

        mCharRv!!.addItemDecoration(SpaceItemDecoration(10))

        mCharRv!!.adapter = KeyboardAdapter()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.tv_clear) {
            if (!TextUtils.isEmpty(content.toString()))
                content.delete(0, content.length)
            if (listener != null) {
                listener!!.onChanged(KEY_EVENT_CLEAR)
                listener!!.onAfterChanged(content.toString())
            }
        } else if (v.id == R.id.tv_backspace) {
            if (!TextUtils.isEmpty(content.toString()))
                content.delete(content.length - 1, content.length)
            if (listener != null) {
                listener!!.onChanged(KEY_EVENT_BACKSPACE)
                listener!!.onAfterChanged(content.toString())
            }
        } else if (v.id == R.id.tv_change) {
            if (listener != null) {
                listener!!.onChanged(KEY_EVENT_CHANGE)
                listener!!.onAfterChanged(content.toString())
            }
        }
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (hasFocus) {
            v.setBackgroundColor(Color.GRAY)
            if (Build.VERSION.SDK_INT >= 21)
                ViewCompat.animate(v).scaleX(1.17f).scaleY(1.17f).translationZ(3.5f).start()
        } else {
            v.setBackgroundColor(Color.parseColor("#5F73f5"))
            if (Build.VERSION.SDK_INT >= 21)
                ViewCompat.animate(v).scaleX(1f).scaleY(1f).translationZ(1f).start()
        }
    }

    private inner class KeyboardAdapter : RecyclerView.Adapter<KeyboardViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyboardViewHolder {
            val v = LayoutInflater.from(context).inflate(R.layout.item_keyboard, parent, false)
            return KeyboardViewHolder(v)
        }

        override fun onBindViewHolder(holder: KeyboardViewHolder, position: Int) {
            holder.tvChar.text = chars[position]

            holder.tvChar.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    holder.tvChar.setBackgroundColor(Color.GRAY)
                    if (Build.VERSION.SDK_INT >= 21)
                        ViewCompat.animate(holder.tvChar).scaleX(1.17f).scaleY(1.17f).translationZ(3.5f).start()
                } else {
                    holder.tvChar.setBackgroundColor(Color.parseColor("#5F73f5"))
                    if (Build.VERSION.SDK_INT >= 21)
                        ViewCompat.animate(holder.tvChar).scaleX(1f).scaleY(1f).translationZ(1f).start()
                }
            }

            holder.tvChar.setOnClickListener {
                if (listener != null) {
                    listener!!.onChanged(chars[position])
                    listener!!.onAfterChanged(content.append(chars[position]).toString())
                }
            }
        }

        override fun getItemCount(): Int {
            return chars.size
        }
    }

    private inner class KeyboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvChar: TextView

        init {
            tvChar = itemView.findViewById(R.id.tv_keyboard) as TextView
        }
    }

    private inner class SpaceItemDecoration internal constructor(private val space: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                    state: RecyclerView.State?) {
            outRect.left = space
            outRect.top = space
        }
    }

    fun setOnTextChangedListener(listener: OnTextChangedListener) {
        this.listener = listener
    }

    interface OnTextChangedListener {
        fun onAfterChanged(content: String)

        fun onChanged(content: String)
    }

    companion object {

        val KEY_EVENT_CLEAR = "-1"
        val KEY_EVENT_BACKSPACE = "-2"
        val KEY_EVENT_CHANGE = "-3"
    }
}
package hu.geribruu.payify.smsreader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import hu.geribruu.payify.R

class SmsAdapter(val context: Context, val list: ArrayList<SmsData>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)

        view.sms_sender.text = list[position].senderName

        view.sms_message.text = list[position].message

        view.sms_date.text = list[position].date

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

}
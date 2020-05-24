package hu.geribruu.payify.smsreader

import android.net.Uri
import androidx.core.app.ActivityCompat
import hu.geribruu.payify.R
import java.util.*
import kotlin.collections.ArrayList

class SmsReader {


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == requestReadSms) {
            setSmsMessages("", null)
        }
    }

    private fun setSmsMessages(uriString: String, selection: String?) {

        val smsList = ArrayList<SmsData>()


        val cursor = contentResolver.query(
            Uri.parse("content://sms/$uriString"),
            null,
            selection,
            null,
            null
        )

        if(cursor!!.moveToFirst()) {

            val nameID = cursor.getColumnIndex("address")

            val messageID = cursor.getColumnIndex("body")

            val dateID = cursor.getColumnIndex("date")

            do {
                val dateString = cursor.getString(dateID)

                smsList.add(
                    SmsData(
                        cursor.getString(nameID),
                        Date(dateString.toLong()).toString(),
                        cursor.getString(messageID)
                    )
                )

            } while (cursor.moveToNext())

        }

        cursor.close()

        val adapter = SmsAdapter(this, smsList)

        sms_list_view.adapter = adapter
    }

    one_number_sms.setOnClickListener {
        setSmsMessages("", "address LIKE '${getString(R.string.phone_number)}'")
    }

    if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_SMS), requestReadSms)

    }
    else {
        //setSmsMessages("", null)
    }

    all_sms.setOnClickListener {
        setSmsMessages("", null)
    }

    inbox_sms.setOnClickListener {
        setSmsMessages("inbox", null)
    }

    outbox_sms.setOnClickListener {
        setSmsMessages("outbox", null)
    }

    sent_sms.setOnClickListener {
        setSmsMessages("sent", null)
    }

    draft_sms.setOnClickListener {
        setSmsMessages("draft", null)
    }
}
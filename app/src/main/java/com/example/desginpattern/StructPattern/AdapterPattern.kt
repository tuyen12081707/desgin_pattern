package com.example.desginpattern.StructPattern

class AdapterPattern {
    val printer = PrinterData("tuyen", "print")
    val service = PDFPrinterService()
    val pdf: PDF = service.print(printer)
    val adapter = PNGAdapter(service)
    val png: PNG = adapter.print(printer)
}
class PDF(
    val text: String
)

class PNG(
    text: String
)
data class PrinterData(
    val title: String,
    val text: String,
)
interface PNGPrinter {
    fun print(data: PrinterData): PNG
}

class PDFPrinterService() {
    fun print(data: PrinterData): PDF {
        return PDF(data.text)
    }
}

class PNGAdapter(val service: PDFPrinterService) : PNGPrinter {
    override fun print(data: PrinterData): PNG {
        val pdf = service.print(data)
        //convert to png
        return PNG(pdf.text)
    }
}


// another example
data class UserEntity(
    val id: Int
)

data class UserRemote(
    val id: Int
)

data class User(
    val id: Int
)

fun UserRemote.toEntity(): UserEntity {
    return UserEntity(id = id)
}


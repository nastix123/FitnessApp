package by.eapp.testingapp_current

interface NecessaryInterface {
    fun print(name: String){
        println("Hello $name")
    }
    fun example():Int {
        var j = 0
        for (i in 1..10)
        {
            j+=i
        }
        return j
    }
}
class Message(val text:String){
    fun sending(){
        println(text)
    }
}
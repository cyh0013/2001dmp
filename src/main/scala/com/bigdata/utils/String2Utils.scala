package com.bigdata.utils

/**
 * String转换工具类
 */
object String2Utils {

  def str2Int(str:String): Int ={
   try{
     str.toInt
   }catch {
     case _:Exception=> 0
   }
  }
  def str2Double(str:String): Double ={
    try{
      str.toDouble
    }catch {
      case _:Exception=> 0.0
    }
  }
}

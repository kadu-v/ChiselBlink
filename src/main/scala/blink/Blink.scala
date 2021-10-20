package blink

import chisel3._
import javax.xml.transform.OutputKeys

class Blink(n: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(Bool())
  })
  val x = RegInit(false.B)
  val cnt = RegInit(0.U(n.W))

  cnt := cnt + 1.U
  io.out := x

  when(cnt === 0.U) {
    x := ~x
  }
}

package blink

import chisel3._

class Top extends Module {
  val io = IO(new Bundle {
    val PIO0 = Output(Bool())
  })
  withReset(~reset.asBool) {
    val c = Module(new Blink(32))
    io.PIO0 := c.io.out
  }
}

object Elaborate extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new Top(), args)
}

package com.insideVM.chapter3;

public class FinalizeEscapeGC {

  public static FinalizeEscapeGC SAVE_HOOK = null;

  public void isAlive() {
    System.out.println("yes, i am still alive");
  }

  // finalize方法何时被调用
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("finalize method executed");
    FinalizeEscapeGC.SAVE_HOOK = this;
  }

  public static void main(String[] args) throws Throwable {
    SAVE_HOOK = new FinalizeEscapeGC();

    // 对象第一次成功拯救自己
    SAVE_HOOK = null;
    System.gc();
    // 因为Finalizer方法优先级很低，暂停0.5秒，以等待他。
    Thread.sleep(500);

    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("no, i am dead:(");
    }

    SAVE_HOOK = null;
    System.gc();
    // 因为Finalizer方法优先级很低，暂停0.5秒，以等待他。
    Thread.sleep(500);

    // 下面这段代码与上面的代码完全相同，但是这次却自救失败了
    SAVE_HOOK = null;
    System.gc();
    // 因为Finalizer方法优先级很低，暂停0.5秒，以等待他。
    Thread.sleep(500);

    if (SAVE_HOOK != null) {
      SAVE_HOOK.isAlive();
    } else {
      System.out.println("no, i am dead:(");
    }
  }
}

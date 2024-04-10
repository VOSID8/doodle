package doodle
package algebra

import doodle.core.ClosedPath

trait Clip extends Algebra {
  def clip[A](img: Drawing[A], clip_path: ClosedPath): Drawing[A]
}

trait ClipConstructor {
  self: BaseConstructor { type Algebra <: Clip} =>

  def clip[A](img: Drawing[A], clip_path: ClosedPath): Drawing[A] = ???
    ///img
    // new Picture[Unit] {
    //   def apply(implicit algebra: Algebra): algebra.Drawing[Unit] = {
    //     algebra.clip(img, clip_path)
    //   }
    // }

  // def clip[A](image: Drawing[A], clip_path: ClosedPath): Picture[A] =
  //   new Picture[A] {
  //     def apply(implicit algebra: Algebra): algebra.Drawing[A] = {
  //       algebra.clip(image, clip_path)
  //     }
  //   }
}

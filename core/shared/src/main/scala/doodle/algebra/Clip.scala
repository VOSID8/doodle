package doodle
package algebra

import doodle.core.ClosedPath
import java.io.File

trait Clip extends Algebra {

  def clip[A](image: Drawing[A], clip_path: ClosedPath): Drawing[A]

}

trait ClipConstructor {
  self: BaseConstructor { type Algebra <: Clip } =>

  def clip(image: Drawing[Unit], clip_path: ClosedPath): Picture[Unit] =
    new Picture[Unit] {
      def apply(implicit algebra: Algebra): algebra.Drawing[Unit] = {
        algebra.clip(image, clip_path)
      }
    }
}

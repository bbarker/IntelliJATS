(*
** Logo-for-ATS
*)

(* ****** ****** *)
//
#include
"share/atspre_define.hats"
#include
"share/atspre_staload.hats"
//
(* ****** ****** *)
//
staload
"{$CAIRO}/SATS/cairo.sats"
//
val PI = 3.1415926536
//
(* ****** ****** *)
//
typedef point = @(double, double)
//
(* ****** ****** *)
//
extern
fun draw_ats (ctx: !xr1): void
extern
fun draw_lambda (ctx: !xr1): void
extern
fun draw_D (ctx: !xr1): void
extern
fun draw_S (ctx: !xr1): void
extern
fun draw_H (ctx: !xr1): void
extern
fun draw_C (ctx: !xr1): void
//
(* ****** ****** *)

// Write a draw Icon Function that
// takes a list or array of other functions
// and calls each of them.

extern
fun draw_ats_and_other(
  fname: String,
  draw_fun: (!xr1) -<fun1> void
):<1> void

implement
draw_ats (ctx) =
{
//
val A0 = (0.00, 0.00)
val A1 = (1.00, 0.00)
val A2 = (2.00, 0.00)
val B0 = (0.00, 0.45)
val B1 = (1.00, 0.45)
val B2 = (2.00, 0.45)
val C0 = (0.00, 1.00)
val C1 = (1.00, 1.00)
val C2 = (2.00, 1.00)
//
val () = cairo_move_to (ctx, A0.0, A0.1)
val () = cairo_line_to (ctx, A2.0, A2.1)
//
val () = cairo_move_to (ctx, A1.0, A1.1)
val () = cairo_line_to (ctx, C1.0, C1.1)
//
val () = cairo_move_to (ctx, B0.0, B0.1)
val () = cairo_line_to (ctx, B2.0, B2.1)
val () = cairo_line_to (ctx, C2.0, C2.1)
val () = cairo_line_to (ctx, C0.0, C0.1)
val ((*closed*)) = cairo_close_path (ctx)
//
} (* end of [draw_ats] *)

(* ****** ****** *)

implement
draw_lambda (ctx) =
{
//
val A0 = (0.00, 0.50)
val B0 = (0.25, 0.25)
val B1 = (0.50+1.0/15, 0.00)
val B2 = (0.75+1.0/15, 0.25)
val C0 = (1.00+1.0/25, 0.50)
val D0 = (1.00-1.0/40, 1.00)
val D1 = (1.00-1.0/40, 1.50)
val E0 = (1.00-1.0/60, 2.00)
val E1 = (1.50-1.0/60, 2.00)
val F0 = (2.00, 2.00)
val H0 = (3.00+0.2500, 2.00)
//
val () = cairo_move_to (ctx, A0.0, A0.1)
val () = cairo_curve_to (ctx, B0.0, B0.1, B1.0, B1.1, B2.0, B2.1)
val () = cairo_curve_to (ctx, B2.0, B2.1, C0.0, C0.1, D0.0, D0.1)
val () = cairo_curve_to (ctx, D1.0, D1.1, E0.0, E0.1, E1.0, E1.1)
val () = cairo_curve_to (ctx, E1.0, E1.1, F0.0, F0.1, H0.0, H0.1)
val () = cairo_move_to (ctx, C0.0-0.10, C0.1+0.20)
val () = cairo_line_to (ctx, 0.00+1.0/18, 2.00+1.0/12.5)
//
} (* end of [draw_lambda] *)

(* ****** ****** *)

implement
draw_D (ctx) =
{
//
val A0 = (0.20, 0.0)
val B0 = (0.20, 2.0)
val B1 = (1.35, 0.35)
val B2 = (1.35, 1.75)
//
val () = cairo_move_to (ctx, A0.0, A0.1)
val () = cairo_line_to (ctx, B0.0, B0.1)
//
val cc = 0.115
val () = cairo_move_to (ctx, A0.0+cc/2.1, A0.1+cc)
val () = cairo_curve_to (ctx, B1.0, B1.1, B2.0, B2.1, B0.0+cc/2.1, B0.1-cc)

} (* end of [draw_D] *)

(* ****** ****** *)

implement
draw_S (ctx) =
{
//
val vs = 1.7
val vi = 0.30
val A0 = (1.25, 0.0)
val B0 = (0.10 - vs, 2.0/3.0 - vi)
val B1 = (1.25 + vs, 4.0/3.0 + vi)
val B2 = (0.10, 2.0)
//
val () = cairo_move_to (ctx, A0.0, A0.1)

// consider multiple Bezier curves instead of just one:
val () = cairo_curve_to (ctx, B0.0, B0.1, B1.0, B1.1, B2.0, B2.1)

} (* end of [draw_S] *)

(* ****** ****** *)

implement
draw_H (ctx) =
{
//

val TL = (0.20, 0.0)
val BL = (0.20, 2.0)
val TR = (1.15, 0.0)
val BR = (1.15, 2.0)
val ML = ((TL.0 + BL.0)/2.0, (TL.1 + BL.1)/2.0)
val MR = ((TR.0 + BR.0)/2.0, (TR.1 + BR.1)/2.0)
//
val () = cairo_move_to (ctx, TL.0, TL.1)
val () = cairo_line_to (ctx, BL.0, BL.1)
//
val () = cairo_move_to (ctx, TR.0, TR.1)
val () = cairo_line_to (ctx, BR.0, BR.1)
//
val () = cairo_move_to (ctx, ML.0, ML.1)
val () = cairo_line_to (ctx, MR.0, MR.1)

} (* end of [draw_H] *)

(* ****** ****** *)

implement
draw_C (ctx) =
{
val s = 0.8
val xt = 0.2
//
val TL = (~0.25 + xt, ~0.25)
val BL = (~0.25 + xt, 2.5)
val TR = (2.0 + xt, ~0.25)
val BR = (2.0 + xt, 2.5)
//
val () = cairo_move_to (ctx, s*TR.0, s*TR.1)
val () = cairo_curve_to (ctx, s*TL.0, s*TL.1, s*BL.0, s*BL.1, s*BR.0, s* BR.1)

} (* end of [draw_C] *)

(* ****** ****** *)

implement
draw_ats_and_other (fname, draw_fun) =
{
//
val sf =
cairo_image_surface_create
  (CAIRO_FORMAT_ARGB32, 400, 400)
//
val ctx = cairo_create (sf)
//
val () =
cairo_arc
 (ctx, 200.0, 200.0, 200.0, 0.0, 2*PI)
val () =
cairo_set_source_rgba (ctx, 1.0, 1.0, 1.0/4, 5.0/6)
val ((*void*)) = cairo_fill (ctx)
//
val () =
cairo_translate (ctx, 36.0, 100.0)
//
val (pf | ()) = cairo_save (ctx)
val ((*void*)) =
  cairo_scale (ctx, 100.0, 100.0)
//
val ((*void*)) = draw_fun (ctx)

val () =
  cairo_set_source_rgb (ctx, 1.0, 0.0, 0.0)
val ((*void*)) = cairo_set_line_width (ctx, 0.24)
val ((*void*)) = cairo_stroke (ctx)
//
val ((*void*)) = cairo_restore (pf | ctx)
//
val (pf | ()) = cairo_save (ctx)
val ((*void*)) =
  cairo_scale (ctx, 80.0, 125.0)
val ((*void*)) =
  cairo_translate (ctx, 1.80, 0.20)
val ((*void*)) = draw_ats (ctx)
val () =
  cairo_set_source_rgb (ctx, 0.0, 0.0, 1.0)
val ((*void*)) = cairo_set_line_width (ctx, 0.16)
val ((*void*)) = cairo_stroke (ctx)
//
val ((*void*)) = cairo_restore (pf | ctx)
//
val status =
  cairo_surface_write_to_png (sf, fname)
val () = cairo_destroy (ctx)
val () = cairo_surface_destroy (sf)
//
val () =
(
if (
status = CAIRO_STATUS_SUCCESS
) then (
  println! ("The image is written to the file [", fname, "].")
) else (
  println! "exit(ATS): [cairo_surface_write_to_png] failed";
) (* end of [if] *)
) : void // end of [val]
//
} (* end of [draw_ats_and_other] *)

implement
main () = (0) where {

val () = draw_ats_and_other("dats_icon.png", draw_D)
val () = draw_ats_and_other("sats_icon.png", draw_S)
val () = draw_ats_and_other("hats_icon.png", draw_H)
val () = draw_ats_and_other("cats_icon.png", draw_C)

} (* end of [main] *)

(* ****** ****** *)

(* end of [theLogo.dats] *)

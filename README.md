"# XOGAME" 
วิธีติดตั้ง
1.เข้าไปที่ลิงค์ https://drive.google.com/file/d/1x6181ax45JvphTDryOext5h5TuWfH_2o/view?usp=sharing
  หรือ https://i.diawi.com/iXTuqG
  หรือ qrcode
2.กด ดาวน์โหลด
3.ทำการติดตั้งได้เฉพาะใน ระบบ Android
4.จากนั้นสามารถเข้าแอปใช้งานได้

Algorithm ที่ใช้
1. เมื่อผู้ใช้ทำการเลือกช่องลง (Array 2 มิติ)
2. เช็คค่าที่อยู่ใน Array มาจาก ตอนผู้ใช้ทำการเลือกขนาดโดยจะทำการสร้าง array ที่มีขนาดเท่ากับผู้ใช้เลือกและกำหนดค่าเริ่มต้นให้ 0 และ เมื่อทำการ กดจะทำการเปลี่ยนค่าใน Array โดยแทนผู้เล่นแรกเป็น 1 และ 
   ผู้เล่นถัดไป เป็น 2
3. โปรแกรมจะทำงานทั้งหมด 4 ฟังก์ชั่น (สามารถดู Code file ServicesTicTacToe)
 3.1 การการ Loop ค่า ใน Array ที่เป็นแนวนอนทั้งหมด และหา ผู้ใช้ที่มีติดกันตามจำนวนขนาด เช่น 3x3 จะมีชนะแนวนอนได้ก็ต้อง 1 ทั้งหมด 3 ตัว หรือ 2 ทั้งหมด 3 ตัว และทำการ Return ค่า true หากเข้าเงื่อนไข
 3.2 การการ Loop ค่า ใน Array ที่เป็นแนวตั่ง ทำเหมือน กับ 3.1 แต่ ในfor จะมีการกำหนดค่าให้สามารถ loop ในแนวตั่งได้
 3.3 การการ Loop ค่า ใน Array ที่เป็นเฉียงซ้ายไปขวา จำทำการ loop เหมือน กับ 3.1 3.2 โดย จะต่างกันตรง for และสร้างตัวแปลในการ loop เพื่อกระให้ไปในแนวเฉียง
 3.4 การการ Loop ค่า ใน Array ที่เป็นเฉียงขวาไปซ้าย จำทำการ loop เหมือน กับ  3.3 โดย จะต่างกันตรง จะเริ่ม loop จาก หลังค่อยๆไล่ระดับลงมา
 3.5 การหาค่าเสมอ โดยจะทำการนำ ค่าที่ Return จาก 3.1 3.2 3.3 3.4 และทำการเช็คขนาดที่กดว่ากด ครบหรือยังหาก ครบแล้วและค่า returnมาเป็นfalseทังหมดจะทำการ ถือว่าเสมอ
 
 ========
 มีการนำ RecyclerView มาทำการ สร้างช่องตาราง
 มีการนำ SQLite มาทำการเก็บข้อมูล History ของผู้แข่ง
 โดยแต่ละหน้าจะใช้การ intent Activity เนื่องจากเห็นว่าจำนวนหน้ามีน้อยจึงไม่ได้นำ fragment เข้ามา
 
 

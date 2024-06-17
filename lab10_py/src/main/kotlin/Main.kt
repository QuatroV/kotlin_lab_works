package org.example

import org.apache.spark.sql.SparkSession

fun main() {
    val spark = SparkSession.builder()
        .appName("USA Cars")
        .master("local[*]")
        .getOrCreate()

    spark.sparkContext().setLogLevel("ERROR")

    val dataset = spark.read().format("csv")
        .option("header", "true")
        .option("inferSchema", "true")
        .load("USA_cars_datasets.csv")

    dataset.createOrReplaceTempView("cars")

    println("Весь датасет:")
    spark.sql("SELECT * FROM cars").show()

    println("1. Сортировка по цене по убыванию")
    spark.sql("SELECT * FROM cars ORDER BY price DESC").show()

    println("2. Автомобили после 2015 года")
    spark.sql("SELECT * FROM cars WHERE year > 2015").show()

    println("3. Количество автомобилей по бренду")
    spark.sql("SELECT brand, COUNT(*) as count FROM cars GROUP BY brand").show()

    println("4. Автомобили с пробегом меньше 50,000")
    spark.sql("SELECT * FROM cars WHERE mileage < 50000").show()

    println("5. Средняя цена автомобилей")
    spark.sql("SELECT AVG(price) as avg_price FROM cars").show()

    println("6. Автомобили из штата Georgia")
    spark.sql("SELECT * FROM cars WHERE state = 'georgia'").show()

    println("7. Автомобили черного цвета")
    spark.sql("SELECT * FROM cars WHERE color = 'black'").show()

    println("8. Сортировка по году по возрастанию")
    spark.sql("SELECT * FROM cars ORDER BY year ASC").show()

    println("9. Автомобили с указанием оставшихся дней")
    spark.sql("SELECT * FROM cars WHERE condition LIKE '%days left%'").show()

    println("10. Максимальная цена по бренду")
    spark.sql("SELECT brand, MAX(price) as max_price FROM cars GROUP BY brand").show()
}

SET foreign_key_checks=1;

USE team2402db;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('taro@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description) VALUES
('トップス', 'トップスのカテゴリーです'),
('ボトムス', 'ボトムスのカテゴリーです'),
('靴', '靴のカテゴリーです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) VALUES
('Ｔシャツ','てぃーしゃつ','サイズ：フリー、カラー：ホワイト',1,6750,'/img/tops/Tshirt.png','2024/03/05','ツバメハウス'),
('パーカー','ぱーかー','サイズ：フリー、カラー：ライトブラウン',1,10800,'/img/tops/hoodie.png','2024/01/30','株式会社AAS'),
('ジーンズ','じーんず','サイズ：フリー、カラー：ブルー',2,22500,'/img/bottoms/jeans.png','2024/02/15','JEANSBIRD本店'),
('スラックス','すらっくす','サイズ：フリー、カラー：ブラック',2,12500,'/img/bottoms/slacks.png','2024/02/05','AvalerKIMURA'),
('スニーカー','すにーかー','サイズ：フリー、カラー：ライトグレー',3,9200,'/img/shoes/sneakers.png','2024/03/10','アウトドアカンパニー渋谷'),
('サンダル','さんだる','サイズ：フリー、カラー：ダークグレー',3,4350,'/img/shoes/sandals.png','2024/02/25','スタイルショップVogel');
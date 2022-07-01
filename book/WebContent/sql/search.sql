-- 商品検索処理
SELECT
	id
	, name
	, price

FROM
    product
WHERE
    name = ?
;
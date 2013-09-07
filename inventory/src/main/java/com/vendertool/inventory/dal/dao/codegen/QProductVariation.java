package com.vendertool.inventory.dal.dao.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QProductVariation is a Querydsl query type for QProductVariation
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QProductVariation extends com.mysema.query.sql.RelationalPathBase<QProductVariation> {

    private static final long serialVersionUID = 2096775078;

    public static final QProductVariation productVariation = new QProductVariation("product_variation");

    public final NumberPath<Integer> availbleQuantity = createNumber("availble_quantity", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final NumberPath<Long> productId = createNumber("product_id", Long.class);

    public final NumberPath<Long> productVariationId = createNumber("product_variation_id", Long.class);

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public final com.mysema.query.sql.PrimaryKey<QProductVariation> primary = createPrimaryKey(productVariationId);

    public QProductVariation(String variable) {
        super(QProductVariation.class, forVariable(variable), "null", "product_variation");
    }

    @SuppressWarnings("all")
    public QProductVariation(Path<? extends QProductVariation> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "product_variation");
    }

    public QProductVariation(PathMetadata<?> metadata) {
        super(QProductVariation.class, metadata, "null", "product_variation");
    }

}


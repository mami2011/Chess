package com.vendertool.listing.dal.dao.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QListingVariation is a Querydsl query type for QBeanListingVariation
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QListingVariation extends com.mysema.query.sql.RelationalPathBase<QBeanListingVariation> {

    private static final long serialVersionUID = 1781649897;

    public static final QListingVariation listingVariation = new QListingVariation("listing_variation");

    public final StringPath condition = createString("condition");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final NumberPath<Byte> lastModifiedApp = createNumber("last_modified_app", Byte.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Long> listingId = createNumber("listing_id", Long.class);

    public final NumberPath<Long> listingVariationId = createNumber("listing_variation_id", Long.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final NumberPath<Long> productVariationId = createNumber("product_variation_id", Long.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<QBeanListingVariation> primary = createPrimaryKey(listingVariationId);

    public QListingVariation(String variable) {
        super(QBeanListingVariation.class, forVariable(variable), "null", "listing_variation");
    }

    @SuppressWarnings("all")
    public QListingVariation(Path<? extends QBeanListingVariation> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "listing_variation");
    }

    public QListingVariation(PathMetadata<?> metadata) {
        super(QBeanListingVariation.class, metadata, "null", "listing_variation");
    }

}


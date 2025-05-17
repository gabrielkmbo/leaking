-- Basic schema for Gas Map Application (PostgreSQL syntax)

CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL, -- Store hashed passwords only!
    email VARCHAR(255) UNIQUE,
    costco_member BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS gas_stations (
    id VARCHAR(255) PRIMARY KEY, -- Could be from an external API or generated
    name VARCHAR(255) NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    address TEXT,
    brand VARCHAR(100),
    -- Regular gas price, diesel, etc., can be more complex
    -- For simplicity, starting with a general price field
    current_price VARCHAR(50), -- e.g., "$3.50/gal" or store as numeric and format in frontend
    price_last_updated TIMESTAMP WITH TIME ZONE,
    has_restroom BOOLEAN,
    -- Add other amenities as needed: car_wash, air_pump, etc.
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Optional: Create an index for geospatial queries if your DB supports it well,
-- or rely on PostGIS for more advanced geospatial features.
-- CREATE INDEX IF NOT EXISTS idx_gas_stations_location ON gas_stations USING gist (ll_to_earth(latitude, longitude));
-- (The above gist index requires the earthdistance extension in PostgreSQL)

-- For simpler radius searches without PostGIS, you'd calculate distance in your application logic.

COMMENT ON COLUMN users.password_hash IS 'Store only hashed passwords, never plain text.';
COMMENT ON COLUMN gas_stations.current_price IS 'Example: "$3.50/gal". Consider storing as numeric for calculations and formatting in the application layer.'; 
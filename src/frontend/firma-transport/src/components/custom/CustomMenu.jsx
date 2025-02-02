import React, { useState } from "react";
import Form from "react-bootstrap/Form";

const CustomMenu = React.forwardRef(
  ({ children, style, className, "aria-labelledby": labeledBy }, ref) => {
    const [value, setValue] = useState("");

    return (
      <div
        ref={ref}
        style={style}
        className={className}
        aria-labelledby={labeledBy}
      >
        <Form.Control
          autoFocus
          className="mx-3 my-2 w-auto"
          placeholder="Caută..."
          onChange={(e) => setValue(e.target.value)}
          value={value}
        />
        <div style={{ maxHeight: "200px", overflowY: "auto" }}>
          <ul className="list-unstyled">
            {React.Children.toArray(children).filter(
              (child) =>
                !value ||
                child.props.children.toLowerCase().includes(value.toLowerCase())
            )}
          </ul>
        </div>
      </div>
    );
  }
);

export default CustomMenu;

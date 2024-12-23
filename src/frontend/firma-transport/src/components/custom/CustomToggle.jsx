import React from "react";

const CustomToggle = React.forwardRef(({ children, onClick }, ref) => (
  <div
    ref={ref}
    onClick={(e) => {
      e.preventDefault();
      onClick(e);
    }}
    style={{
      display: "flex",
      alignItems: "center",
      justifyContent: "space-between",
      padding: "10px",
      border: "1px solid #ced4da",
      borderRadius: "4px",
      cursor: "pointer",
      backgroundColor: "#fff",
    }}
  >
    {children}
    <span>&#x25bc;</span> {/* Dropdown arrow */}
  </div>
));

export default CustomToggle;
